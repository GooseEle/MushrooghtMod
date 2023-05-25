package theMushrooght.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.actions.i2RhizoctoniaTalantAction;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i29Rhizoctonia extends AbstractDynamicCard {



    public static String ID = theMushrooght.MushrooghtMod.makeID(i29Rhizoctonia.class.getSimpleName());
    public static String IMG = makeCardPath("i29Rhizoctonia.png");

    private static CardRarity RARITY = CardRarity.UNCOMMON;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 1;
    private static int UPGRADE_COST = 0;
    private static int TALANT = 1;



    // /STAT DECLARATION/


    public i29Rhizoctonia() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i29Rhizoctonia.png");
        
        magicNumber = baseMagicNumber = TALANT;


    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new i2RhizoctoniaTalantAction(this.magicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBaseCost(UPGRADE_COST);
            initializeDescription();
        }
    }
}