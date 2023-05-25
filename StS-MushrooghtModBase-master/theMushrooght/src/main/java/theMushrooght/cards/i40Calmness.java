package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.player;
import static theMushrooght.MushrooghtMod.makeCardPath;
public class i40Calmness extends AbstractDynamicCard {

    public static String ID = theMushrooght.MushrooghtMod.makeID(i40Calmness.class.getSimpleName());
    public static String IMG = makeCardPath("i40Calmness.png");

    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.NONE;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;
    private static int COST = -2;

    public i40Calmness() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i40Calmness.png");
        
        this.selfRetain = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {}

    public void triggerOnEndOfTurnForPlayingCard() {
        addToBot(new ApplyPowerAction(player, player, new BlurPower(player, 1), 1));
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return false;
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
    public boolean canUpgrade() {return false;
    }

    public AbstractCard makeCopy() {
        return new i40Calmness();
    }
}