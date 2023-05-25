package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i15Psilocin extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i15Psilocin.class.getSimpleName());
    public static final String IMG = makeCardPath("i15Psilocin.png");


    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = 1;
    private static final int POISON = 3;
    private static final int UPGRADE_PLUS_POISON = 4;

    // /STAT DECLARATION/

    public i15Psilocin() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = POISON;
        MushrooghtMod.loadJokeCardImage(this, "i15Psilocin.png");
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        new ApplyPowerAction(m, p, new PoisonPower(m, p, this.defaultSecondMagicNumber), this.defaultSecondMagicNumber);
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDefaultSecondMagicNumber(UPGRADE_PLUS_POISON);
            this.initializeDescription();
        }
    }
}