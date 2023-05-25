package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FrailPower;
import theMushrooght.MushrooghtMod;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i82Mycoheterotrophy extends AbstractDynamicCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i82Mycoheterotrophy.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillCurse.png");



    private static final CardRarity RARITY = CardRarity.CURSE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.CURSE;

    public static final CardColor COLOR = AbstractCard.CardColor.CURSE;

    private static final int COST = -2;





    public i82Mycoheterotrophy() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, ".png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (this.dontTriggerOnUseCard)
            addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new FrailPower(AbstractDungeon.player, 1, true), 1));
    }

    public void triggerOnEndOfTurnForPlayingCard() {
        this.dontTriggerOnUseCard = true;
        AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(this, true));
    }


    @Override
    public void upgrade() {}

    public AbstractCard makeCopy() {
        return new i82Mycoheterotrophy();
    }
}