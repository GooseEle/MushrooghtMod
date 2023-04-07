package theMushrooght.actions;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveAllBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theMushrooght.powers.i3UnsafeBlockPower;
import theMushrooght.powers.i6MyceliumPower;

public class i6UnsafeBlockAction extends AbstractGameAction {
    private AbstractCreature c;

    public i6UnsafeBlockAction(AbstractCreature c) {
        this.c = c;
        this.actionType = AbstractGameAction.ActionType.WAIT;
    }

    public void update() {
        int amount = this.c.currentBlock;
        if (amount >= 1) {
            AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(this.c, this.c, new i3UnsafeBlockPower(this.c, amount), amount));
            AbstractDungeon.actionManager.addToTop(new RemoveAllBlockAction(this.c, this.c));
        }
        this.isDone = true;
    }
}