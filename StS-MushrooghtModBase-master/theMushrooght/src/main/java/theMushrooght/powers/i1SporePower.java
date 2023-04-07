package theMushrooght.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import theMushrooght.MushrooghtMod;
import theMushrooght.util.TextureLoader;
public class i1SporePower extends AbstractPower {
    public static final String POWER_ID = MushrooghtMod.makeID("i1SporePower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    private static final Logger logger = LogManager.getLogger(i1SporePower.class.getName());
    private static final Texture tex84 = TextureLoader.getTexture(MushrooghtMod.makePowerPath("spore_power84.png"));
    private static final Texture tex32 = TextureLoader.getTexture(MushrooghtMod.makePowerPath("spore_power32.png"));
    public i1SporePower(AbstractCreature owner, int amt) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amt;
        this.type = AbstractPower.PowerType.DEBUFF;
        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);
        updateDescription();
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + FontHelper.colorString(this.owner.name, "y") + DESCRIPTIONS[1]
                + DESCRIPTIONS[2] + (this.amount * 10) + DESCRIPTIONS[3];
    }
    public void atEndOfRound() {
        if (this.amount <= 1) {
            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
        } else {
                AbstractDungeon.actionManager.addToBottom(new ReducePowerAction(this.owner, this.owner, POWER_ID, ((this.amount / 3) * 2)));
        }
    }
    public float atDamageReceive(float damage, DamageInfo.DamageType type) {
        if (type == DamageInfo.DamageType.NORMAL) {
            return damage * ((this.amount * 0.1F) + 1F);
        }
        return damage;
    }
}
