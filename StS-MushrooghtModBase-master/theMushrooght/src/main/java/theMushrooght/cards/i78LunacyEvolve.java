package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;
import theMushrooght.powers.i16LunacyEvolvePower;
import theMushrooght.powers.i2WeaknessSporePower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i78LunacyEvolve extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i78LunacyEvolve.class.getSimpleName());
    public static String IMG = makeCardPath("i78LunacyEvolve.png");


    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.ALL;
    private static CardType TYPE = CardType.POWER;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;
    private static int COST = 1;
    private static int MYCO = 3;
    private static int UPGRADE_PLUS_MYCO = 2;

    // /STAT DECLARATION/

    public i78LunacyEvolve() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i78LunacyEvolve.png");
        
        magicNumber = baseMagicNumber = MYCO;

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new i16LunacyEvolvePower(p, magicNumber), magicNumber));

        for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
            addToBot(new ApplyPowerAction(monster, p, new i2WeaknessSporePower(monster, 1), 1));
        }
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_MYCO);
            this.initializeDescription();
        }
    }
}
