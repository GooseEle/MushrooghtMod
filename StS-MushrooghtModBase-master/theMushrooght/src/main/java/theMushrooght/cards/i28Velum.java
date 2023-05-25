package theMushrooght.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.actions.i1VelumEnergyAction;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i28Velum extends AbstractDynamicCard {



    public static String ID = theMushrooght.MushrooghtMod.makeID(i28Velum.class.getSimpleName());
    public static String IMG = makeCardPath("i28Velum.png");
    private static CardRarity RARITY = CardRarity.UNCOMMON;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 2;

    private static int ENERGY = 1;



    // /STAT DECLARATION/


    public i28Velum() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i28Velum.png");
        
        magicNumber = baseMagicNumber = ENERGY;

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new i1VelumEnergyAction(this.magicNumber));
    }


    @Override
    public void upgrade() {
        if (!this.upgraded) {
            if (Settings.language == Settings.GameLanguage.ENG) {
                this.name = "DONT DO THIS YOU LITTLE MUSH LOVER";
            } else if (Settings.language == Settings.GameLanguage.RUS) {
                this.name = "НЕ ДЕЛАЙ ЭТОГО ТЫ МАЛЕНЬКИЙ ЛЮБИТЕЛЬ ГРИБОЧКОВ";
            } else {
                this.name = "(╯°□°)╯︵ ┻━┻";
            }
        }
    }
    public boolean canUpgrade() {
        return false;
    }

    public AbstractCard makeCopy() {
        return new i28Velum();
    }
}

