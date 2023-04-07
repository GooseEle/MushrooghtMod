package theMushrooght.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.actions.i1VelumEnergyAction;
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i28Velum extends AbstractDynamicCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i28Velum.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillUncommon.png");

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 2;

    private static final int ENERGY = 1;



    // /STAT DECLARATION/


    public i28Velum() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = ENERGY;

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new i1VelumEnergyAction(this.magicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {}

    public AbstractCard makeCopy() {
        return new i28Velum();
    }
}

