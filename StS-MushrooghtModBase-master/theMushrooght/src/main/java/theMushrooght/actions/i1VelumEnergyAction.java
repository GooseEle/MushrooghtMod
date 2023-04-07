package theMushrooght.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class i1VelumEnergyAction extends AbstractGameAction {
    private int energyPerCard;

    public i1VelumEnergyAction(int energyAmount) {
        this.energyPerCard = energyAmount;
        setValues(AbstractDungeon.player, AbstractDungeon.player);
        this.actionType = ActionType.ENERGY;
    }

    public void update() {
        ArrayList<AbstractCard> cardsToExhaust = new ArrayList<>();
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            if (c.type != AbstractCard.CardType.SKILL)
                cardsToExhaust.add(c);
        }
        for (AbstractCard c : cardsToExhaust)
            addToTop(new GainEnergyAction(this.energyPerCard));
        for (AbstractCard c : cardsToExhaust)
            addToTop(new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand));
        this.isDone = true;
    }
}
