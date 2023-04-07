package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.powers.i17BizarreParasitePower;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.player;
import static theMushrooght.MushrooghtMod.makeCardPath;

public class i81BizarreParasite extends AbstractDynamicCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i81BizarreParasite.class.getSimpleName());
    public static final String IMG = makeCardPath("i81BizarreParasite.png");



    private static final CardRarity RARITY = CardRarity.CURSE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.CURSE;

    public static final CardColor COLOR = AbstractCard.CardColor.CURSE;

    private static final int COST = -2;



    public void use(AbstractPlayer p, AbstractMonster m) {}


    public i81BizarreParasite() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i81BizarreParasite.png");
    }

    public void triggerOnExhaust() {
        addToBot(new ApplyPowerAction(player, player, new i17BizarreParasitePower(player, 1), 1));
        addToBot(new DrawCardAction(player, 1));
        CardCrawlGame.sound.play("BLOOD_SWISH");
        }


    @Override
    public void upgrade() {}

    public AbstractCard makeCopy() {
        return new i81BizarreParasite();
    }
}
