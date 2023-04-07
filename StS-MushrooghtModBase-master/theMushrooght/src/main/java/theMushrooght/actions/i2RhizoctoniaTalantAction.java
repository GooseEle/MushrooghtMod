package theMushrooght.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import java.util.ArrayList;

public class i2RhizoctoniaTalantAction extends AbstractGameAction {
    private int energyhpPerCard;

    public i2RhizoctoniaTalantAction(int energyhpAmount) {
        this.energyhpPerCard = energyhpAmount;
        setValues(AbstractDungeon.player, AbstractDungeon.player);
        this.actionType = ActionType.WAIT;
    }

    public void update() {
        ArrayList<AbstractCard> cardsToExhaust = new ArrayList<>();
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            if (c.type != AbstractCard.CardType.POWER)
                cardsToExhaust.add(c);
        }
        for (AbstractCard c : cardsToExhaust)
            addToTop(new GainEnergyAction(this.energyhpPerCard));
        addToBot(new HealAction(AbstractDungeon.player, AbstractDungeon.player, this.energyhpPerCard));

        for (AbstractCard c : cardsToExhaust)
            addToTop(new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand));
        this.isDone = true;
    }
}
