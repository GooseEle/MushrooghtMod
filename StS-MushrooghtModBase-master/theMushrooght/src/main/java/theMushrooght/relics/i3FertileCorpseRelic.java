package theMushrooght.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theMushrooght.cards.AbstractGrowthCard;
import theMushrooght.util.TextureLoader;

import static theMushrooght.MushrooghtMod.makeRelicOutlinePath;
import static theMushrooght.MushrooghtMod.makeRelicPath;

public class i3FertileCorpseRelic extends CustomRelic {
    public static final String ID = theMushrooght.MushrooghtMod.makeID("i3FertileCorpseRelic");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("i3FertileCorpseRelic.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("i3FertileCorpseRelic.png"));

    public i3FertileCorpseRelic() {
        super(ID, IMG, OUTLINE, RelicTier.UNCOMMON, LandingSound.FLAT);
    }
    // Gain 1 energy on equip.

    public void atBattleStartPreDraw() {
        addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        addToBot(new MakeTempCardInHandAction(AbstractGrowthCard.returnRandomGrowth(), 1, false));
    }
    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

}