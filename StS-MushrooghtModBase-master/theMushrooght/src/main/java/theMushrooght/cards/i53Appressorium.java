package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i1SporePower;
import theMushrooght.powers.i2WeaknessSporePower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i53Appressorium extends AbstractDynamicCard {

    public static final String ID = theMushrooght.MushrooghtMod.makeID(i53Appressorium.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = makeCardPath("AttackUncommon.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int SPORES = 2;
    private static final int UPGRADE_PLUS_SPORES = 2;
    private static final int WEAKSPORES = 2;
    private static final int UPGRADE_PLUS_WEAKSPORES = 1;
    private static final int COST = 2;
    private static final int DAMAGE = 14;

    public i53Appressorium() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseDamage = DAMAGE;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = WEAKSPORES;
        magicNumber = baseMagicNumber = SPORES;
        MushrooghtMod.loadJokeCardImage(this, ".png");

    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL);
        addToBot(new ApplyPowerAction(m, p, new i2WeaknessSporePower(m, defaultSecondMagicNumber), defaultSecondMagicNumber));
        addToBot(new ApplyPowerAction(m, p, new i1SporePower(m, magicNumber), magicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_SPORES);
            this.upgradeDefaultSecondMagicNumber(UPGRADE_PLUS_WEAKSPORES);
            initializeDescription();
        }
    }
}