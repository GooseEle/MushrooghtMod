package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.unique.ExhumeAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i35Forcing extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i35Forcing.class.getSimpleName());
    public static String IMG = makeCardPath("i35Forcing.png");

    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.NONE;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = -2;


    // /STAT DECLARATION/

    public i35Forcing() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i35Forcing.png");
        


    }

    public void triggerWhenDrawn() {
        addToBot(new ExhumeAction(false));
        addToTop(new ExhaustSpecificCardAction(this, AbstractDungeon.player.hand));
    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {}

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return false;
    }
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
        return new i35Forcing();
    }
}