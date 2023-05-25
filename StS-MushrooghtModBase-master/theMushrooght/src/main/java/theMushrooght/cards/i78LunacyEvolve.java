package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i16LunacyEvolvePower;
import theMushrooght.powers.i2WeaknessSporePower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i78LunacyEvolve extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i78LunacyEvolve.class.getSimpleName());
    public static final String IMG = makeCardPath("PowerRare.png");


    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ALL;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = 1;
    private static final int MYCO = 3;
    private static final int UPGRADE_PLUS_MYCO = 2;

    // /STAT DECLARATION/

    public i78LunacyEvolve() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = MYCO;
        MushrooghtMod.loadJokeCardImage(this, ".png");

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
