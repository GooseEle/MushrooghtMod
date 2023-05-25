package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.unique.ExhumeAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i35Forcing extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i35Forcing.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillRare.png");


    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = -2;


    // /STAT DECLARATION/

    public i35Forcing() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);


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
        this.name = cardStrings.EXTENDED_DESCRIPTION[0];
    }
    public boolean canUpgrade() {
        return false;
    }

    public AbstractCard makeCopy() {
        return new i35Forcing();
    }
}