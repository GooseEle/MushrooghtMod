package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.BetterDrawPileToHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;
public class i39Adapting extends AbstractDynamicCard {

    public static final String ID = theMushrooght.MushrooghtMod.makeID(i39Adapting.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillRare.png");
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = -2;

    public i39Adapting() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
    }

    public void triggerWhenDrawn() {
        addToBot(new BetterDrawPileToHandAction(1));
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {}
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {return false;}

    @Override
    public void upgrade() {}
}
