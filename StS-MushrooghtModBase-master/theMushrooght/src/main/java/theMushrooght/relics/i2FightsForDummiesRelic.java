package theMushrooght.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theMushrooght.util.TextureLoader;

import static com.megacrit.cardcrawl.cards.AbstractCard.CardTags.STARTER_DEFEND;
import static com.megacrit.cardcrawl.cards.AbstractCard.CardTags.STRIKE;
import static theMushrooght.MushrooghtMod.makeRelicOutlinePath;
import static theMushrooght.MushrooghtMod.makeRelicPath;

public class i2FightsForDummiesRelic extends CustomRelic {
    public static final String ID = theMushrooght.MushrooghtMod.makeID("i2FightsForDummiesRelic");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("i2FightsForDummiesRelic.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("i2FightsForDummiesRelic.png"));
    private boolean gainEnergyNext = false, firstTurn = false;

    public i2FightsForDummiesRelic() {
        super(ID, IMG, OUTLINE, RelicTier.COMMON, LandingSound.FLAT);
        this.pulse = false;
    }
    // Gain 1 energy on equip.
    public void atPreBattle() {
        flash();
        this.firstTurn = true;
        this.gainEnergyNext = true;
        if (!this.pulse) {
            beginPulse();
            this.pulse = true;
        }
    }

    public void atTurnStart() {
        beginPulse();
        this.pulse = true;
        if (this.gainEnergyNext && !this.firstTurn) {
            flash();
            addToBot(new RelicAboveCreatureAction( AbstractDungeon.player, this));
            addToBot(new GainEnergyAction(1));
        }
        this.firstTurn = false;
        this.gainEnergyNext = true;
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.hasTag(STRIKE) || card.hasTag(STARTER_DEFEND)) {
            this.gainEnergyNext = true;
            this.pulse = true;
        } else {
            this.gainEnergyNext = false;
            this.pulse = false;
        }
    }

    public void onVictory() {
        this.pulse = false;
    }
    // Description
    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0] + this.DESCRIPTIONS[1];
    }

}
