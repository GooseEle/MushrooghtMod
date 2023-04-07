package theMushrooght.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import theMushrooght.MushrooghtMod;
import theMushrooght.cards.i81BizarreParasite;
import theMushrooght.util.TextureLoader;
public class i15PutridHeartPower extends AbstractPower {
    public static final String POWER_ID = MushrooghtMod.makeID("i15PutridHeartPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);

    public static final String NAME = powerStrings.NAME;

    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    private static final Logger logger = LogManager.getLogger(i15PutridHeartPower.class.getName());
    private static final Texture tex84 = TextureLoader.getTexture(MushrooghtMod.makePowerPath("putridheart_power84.png"));
    private static final Texture tex32 = TextureLoader.getTexture(MushrooghtMod.makePowerPath("putridheart_power32.png"));

    public i15PutridHeartPower(AbstractCreature owner, int DrawAndParasiteAmount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = DrawAndParasiteAmount;
        this.type = AbstractPower.PowerType.BUFF;
        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);
        updateDescription();
    }

    public void updateDescription() {
        if (this.amount == 1) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2];
        } else {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[3];
        }
    }

    public void atStartOfTurnPostDraw() {
        flash();
        addToBot(new DrawCardAction(this.owner, this.amount));
        new MakeTempCardInDiscardAction(new i81BizarreParasite(), 1);
    }
}