package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.powers.i7ConstrainedPower;
import theMushrooght.powers.i8LassitudePower;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.player;
import static theMushrooght.MushrooghtMod.makeCardPath;

public class i80Bogue extends AbstractDynamicCard {



    public static String ID = theMushrooght.MushrooghtMod.makeID(i80Bogue.class.getSimpleName());
    public static String IMG = makeCardPath("i80Bogue.png");

    private static CardRarity RARITY = CardRarity.CURSE;
    private static CardTarget TARGET = CardTarget.NONE;
    private static CardType TYPE = CardType.CURSE;

    public static CardColor COLOR = AbstractCard.CardColor.CURSE;
    private static int COST = -2;

    public i80Bogue() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i80Bogue.png");
        
    }

    public void use(AbstractPlayer p, AbstractMonster m) {}

    public void triggerOnEndOfPlayerTurn() {
        addToBot(new ApplyPowerAction(player, player, new i7ConstrainedPower(player, 1), 1));
        addToBot(new ApplyPowerAction(player, player, new i8LassitudePower(player, 1), 1));
        addToBot(new ApplyPowerAction(player, player, new DrawCardNextTurnPower(player, 1), 1));
        addToTop(new ExhaustSpecificCardAction(this, AbstractDungeon.player.hand));
    }


    @Override
    public void upgrade() {}

    public AbstractCard makeCopy() {
        return new i80Bogue();
    }
}

