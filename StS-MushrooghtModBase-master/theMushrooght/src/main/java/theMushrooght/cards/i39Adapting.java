package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.BetterDrawPileToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;
public class i39Adapting extends AbstractDynamicCard {

    public static String ID = theMushrooght.MushrooghtMod.makeID(i39Adapting.class.getSimpleName());
    public static String IMG = makeCardPath("i39Adapting.png");

    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.NONE;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;
    private static int COST = -2;

    public i39Adapting() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i39Adapting.png");
        
    }

    public void triggerWhenDrawn() {
        addToBot(new BetterDrawPileToHandAction(1));
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {}
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {return false;}
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
        return new i39Adapting();
    }
}
