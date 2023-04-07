package theMushrooght.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import java.util.Iterator;

public class i4ReduceDebuffsAction extends AbstractGameAction {
    private AbstractCreature c;

    public i4ReduceDebuffsAction(AbstractCreature c, int amount) {
        this.c = c;
        this.duration = 0.5F;
        this.amount = amount;
    }

    public void update() {
        Iterator<AbstractPower> var1 = this.c.powers.iterator();
        while (var1.hasNext()) {
            AbstractPower p = var1.next();
            if (p.type == AbstractPower.PowerType.DEBUFF)
                addToTop(new ReducePowerAction(this.c, this.c, p.ID, this.amount));
        }
        this.isDone = true;
    }
}

