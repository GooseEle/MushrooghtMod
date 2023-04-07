package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;
import theMushrooght.characters.TheDefault;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.player;
import static theMushrooght.MushrooghtMod.makeCardPath;
public class i40Calmness extends AbstractDynamicCard {

    public static final String ID = theMushrooght.MushrooghtMod.makeID(i40Calmness.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillRare.png");
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = -2;

    public i40Calmness() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
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
    public void upgrade() {}

    public AbstractCard makeCopy() {
        return new i40Calmness();
    }
}