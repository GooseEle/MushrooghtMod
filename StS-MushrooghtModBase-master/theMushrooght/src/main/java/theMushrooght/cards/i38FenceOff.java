package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i6MyceliumPower;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.player;
import static theMushrooght.MushrooghtMod.makeCardPath;
public class i38FenceOff extends AbstractDynamicCard {

    public static final String ID = theMushrooght.MushrooghtMod.makeID(i38FenceOff.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillRare.png");
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = -2;
    private static final int MYCELIUM = 5;
    private static final int UPGRADE_PLUS_MYCELIUM = 2;

    public i38FenceOff() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = MYCELIUM;
    }

    public void triggerWhenDrawn() {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(player, player, new i6MyceliumPower(player, player, magicNumber), magicNumber));
        addToBot(new DrawCardAction(player, 1));
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {}
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {return false;}


    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            initializeDescription();
            this.upgradeMagicNumber(UPGRADE_PLUS_MYCELIUM);
        }
    }
}
