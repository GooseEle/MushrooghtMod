package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.powers.i7ConstrainedPower;
import theMushrooght.powers.i8LassitudePower;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.player;
import static theMushrooght.MushrooghtMod.makeCardPath;

public class i80Bogue extends AbstractDynamicCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i80Bogue.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillCurse.png");

    private static final CardRarity RARITY = CardRarity.CURSE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.CURSE;

    public static final CardColor COLOR = AbstractCard.CardColor.CURSE;
    private static final int COST = -2;

    public i80Bogue() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, ".png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {}

    public void triggerOnEndOfPlayerTurn() {
        addToBot(new ApplyPowerAction(player, player, new i7ConstrainedPower(player, 1), 1));
        addToBot(new ApplyPowerAction(player, player, new i8LassitudePower(player, 1), 1));
        addToTop(new ExhaustSpecificCardAction(this, AbstractDungeon.player.hand));
    }


    @Override
    public void upgrade() {}

    public AbstractCard makeCopy() {
        return new i80Bogue();
    }
}

