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
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i3DrainPower extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i3DrainPower.class.getSimpleName());
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static String IMG = makeCardPath("i3DrainPower.png");


    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;


    private static CardRarity RARITY = CardRarity.BASIC;
    private static CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static CardType TYPE = CardType.ATTACK;

    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 1;
    private static int DAMAGE = 2;
    private static int UPGRADE_PLUS_DMG = 2;
    private static int STRENGTH = 1;

    private static int UPGRADE_PLUS_STRENGTH = 1;


    public i3DrainPower() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i3DrainPower.png");
        
        this.exhaust = true;
        baseDamage = DAMAGE;
        magicNumber = baseMagicNumber = 2;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = STRENGTH;
        
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