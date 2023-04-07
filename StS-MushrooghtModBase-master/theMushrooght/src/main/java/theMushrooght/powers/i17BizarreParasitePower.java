package theMushrooght.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import theMushrooght.MushrooghtMod;
import theMushrooght.util.TextureLoader;

public class i17BizarreParasitePower extends AbstractPower {
    public static final String POWER_ID = MushrooghtMod.makeID("i17BizarreParasitePower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    private static final Logger logger = LogManager.getLogger(i17BizarreParasitePower.class.getName());
    private static final Texture tex84 = TextureLoader.getTexture(MushrooghtMod.makePowerPath("bizarreparasite_power84.png"));
    private static final Texture tex32 = TextureLoader.getTexture(MushrooghtMod.makePowerPath("bizarreparasite_power32.png"));
    public i17BizarreParasitePower(AbstractCreature owner, int amt) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amt;
        this.type = AbstractPower.PowerType.BUFF;
        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);
        updateDescription();
    }

    public void onVictory() {
        AbstractPlayer p = AbstractDungeon.player;
        if (AbstractDungeon.player.hasRelic("theMushrooght:i11GigaparasiteRelic")) {
            if (p.currentHealth > 0 && this.amount >= 11) {
                p.heal(11);
            } else {
                p.heal(this.amount);
            }
        } else {
            if (p.currentHealth > 0 && this.amount >= 5) {
                p.heal(5);
            } else {
                p.heal(this.amount);
        }
    }
    }


    public void updateDescription() {
        if (AbstractDungeon.player.hasRelic("theMushrooght:i11GigaparasiteRelic")) {
            if (this.amount >= 11) {
                this.description = DESCRIPTIONS[0] + 11 + DESCRIPTIONS[1];
            } else {
                this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
            }
        } else {
            if (this.amount >= 5) {
                this.description = DESCRIPTIONS[0] + 5 + DESCRIPTIONS[2];
            } else {
                this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[2];
            }
        }
    }
}
