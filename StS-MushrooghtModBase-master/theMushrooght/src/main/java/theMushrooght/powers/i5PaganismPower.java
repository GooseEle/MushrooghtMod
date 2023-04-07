package theMushrooght.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.cards.i80Bogue;
import theMushrooght.util.TextureLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class i5PaganismPower extends AbstractPower {
    public AbstractCreature source;
    public static final String POWER_ID = MushrooghtMod.makeID("i5PaganismPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);

    public static final String NAME = powerStrings.NAME;

    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    private static final Logger logger = LogManager.getLogger(i5PaganismPower.class.getName());

    private static final Texture tex84 = TextureLoader.getTexture(MushrooghtMod.makePowerPath("paganism_power84.png"));

    private static final Texture tex32 = TextureLoader.getTexture(MushrooghtMod.makePowerPath("paganism_power32.png"));

    public i5PaganismPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.source = source;
        this.type = AbstractPower.PowerType.BUFF;
        this.isTurnBased = true;
        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);
        updateDescription();
    }

    public void stackPower(int stackAmount) {
        if (this.amount == -1) {
            logger.info(this.name + " does not stack");
            return;
        }
        this.fontScale = 8.0F;
        this.amount += stackAmount;
        updateDescription();
    }

    public void onEnergyRecharge() {
        flash();
        for (int i = 1; i <= this.amount; i++)
            addToBot(new MakeTempCardInDiscardAction(new i80Bogue(), 1));
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}