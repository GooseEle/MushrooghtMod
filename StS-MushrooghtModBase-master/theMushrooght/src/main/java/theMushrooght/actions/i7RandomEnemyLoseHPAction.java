package theMushrooght.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class i7RandomEnemyLoseHPAction extends AbstractGameAction {

    public i7RandomEnemyLoseHPAction(AbstractGameAction.AttackEffect effect) {
    }

    public i7RandomEnemyLoseHPAction() {
        this(AbstractGameAction.AttackEffect.NONE);
    }

    public void update() {
        this.target = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
        new LoseHPAction(this.target, this.target, 1);
        this.isDone = true;
    }
}
