package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.combat.ShockWaveEffect;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i3DrainPower extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i3DrainPower.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("i3DrainPower.png");


    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;


    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static final CardType TYPE = CardType.ATTACK;

    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 1;
    private static final int DAMAGE = 2;
    private static final int UPGRADE_PLUS_DMG = 2;
    private static final int STRENGTH = 1;

    private static final int UPGRADE_PLUS_STRENGTH = 1;


    public i3DrainPower() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        this.exhaust = true;
        baseDamage = DAMAGE;
        magicNumber = baseMagicNumber = 2;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = STRENGTH;
        MushrooghtMod.loadJokeCardImage(this, "i3DrainPower.png");
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot( new SFXAction("ATTACK_PIERCING_WAIL"));
        if (Settings.FAST_MODE) {
            addToBot( new VFXAction( p,  new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.GREEN_TEXT_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 0.3F));
        } else {
            addToBot( new VFXAction( p,  new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.GREEN_TEXT_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 1.5F));
        }
        for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters)
            addToBot( new ApplyPowerAction( mo,  p,  new StrengthPower( mo, -this.defaultSecondMagicNumber), -this.defaultSecondMagicNumber, true, AbstractGameAction.AttackEffect.NONE));
        for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            if (!mo.hasPower("Artifact"))
                addToBot( new ApplyPowerAction( mo,  p,  new GainStrengthPower( mo, this.defaultSecondMagicNumber), this.defaultSecondMagicNumber, true, AbstractGameAction.AttackEffect.NONE));
        }
        for (int i = 0; i < this.magicNumber; i++)
            addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }


    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
            this.upgradeDefaultSecondMagicNumber(UPGRADE_PLUS_STRENGTH);
            initializeDescription();
        }
    }
}