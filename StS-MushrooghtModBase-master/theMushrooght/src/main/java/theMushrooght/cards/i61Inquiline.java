package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.SunderAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.MetallicizePower;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i61Inquiline extends AbstractDynamicCard {

    public static String ID = theMushrooght.MushrooghtMod.makeID(i61Inquiline.class.getSimpleName());
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String IMG = makeCardPath("i61Inquiline.png");

    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;
    private static CardRarity RARITY = CardRarity.UNCOMMON;
    private static CardTarget TARGET = CardTarget.ENEMY;
    private static CardType TYPE = CardType.ATTACK;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 1;
    private static int DAMAGE = 8;
    private static int UPGRADE_PLUS_DMG = 2;


    public i61Inquiline() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i61Inquiline.png");
        
        baseDamage = DAMAGE;

    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SunderAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), 3));
            new ApplyPowerAction(m, p, new MetallicizePower(m, -1), -1);
            new ApplyPowerAction(m, p, new PlatedArmorPower(m, -1), -1);
        new ApplyPowerAction(m, p, new VulnerablePower(m, 1, false), 1);
    }

    public void triggerOnGlowCheck() {
        this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
        for (AbstractMonster m : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            if (!m.isDeadOrEscaped() && m.hasPower("Metallicize")) {
                this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
                break;
            } else if (!m.isDeadOrEscaped() && m.hasPower("Plated Armor")) {
                this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
                break;
            }
        }
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
