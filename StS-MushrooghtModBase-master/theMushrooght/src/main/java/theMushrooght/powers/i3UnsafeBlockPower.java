package theMushrooght.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.BlurPower;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import theMushrooght.MushrooghtMod;
import theMushrooght.util.TextureLoader;

public class i3UnsafeBlockPower extends AbstractPower {
    public AbstractCreature source;
    public static final String POWER_ID = MushrooghtMod.makeID("i3UnsafeBlockPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);

    public static final String NAME = powerStrings.NAME;

    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    private static final Logger logger = LogManager.getLogger(i3UnsafeBlockPower.class.getName());

    private static final Texture tex84 = TextureLoader.getTexture(MushrooghtMod.makePowerPath("unsafeblock_power84.png"));

    private static final Texture tex32 = TextureLoader.getTexture(MushrooghtMod.makePowerPath("unsafeblock_power32.png"));
    public i3UnsafeBlockPower(AbstractCreature owner, int amount) {
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
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    public void atStartOfTurn() {
        flash();
        AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.owner.hb.cX, this.owner.hb.cY, AbstractGameAction.AttackEffect.SHIELD));
        addToBot(new GainBlockAction(this.owner, this.owner, this.amount));
        addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
    }

    public float modifyBlock(float blockAmount) {
        return blockAmount * 0.5F;
    }

    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(this.owner, this.owner, new BlurPower(this.owner, 1), 1));
    }
}