package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.defect.SunderAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.WeightyImpactEffect;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i62Compost extends AbstractDynamicCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i62Compost.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = makeCardPath("AttackUncommon.png");



    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;


    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 3;
    private static final int DAMAGE = 24;
    private static final int UPGRADE_PLUS_DMG = 8;


    public i62Compost() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseDamage = DAMAGE;
        MushrooghtMod.loadJokeCardImage(this, ".png");

    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m != null) {
        addToBot(new VFXAction(new WeightyImpactEffect(m.hb.cX, m.hb.cY)));
        addToBot(new WaitAction(0.8F));
    }
    addToBot(new SunderAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), 3));
    }


    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
            initializeDescription();
        }
    }
}
