package io.github.ai.behaviortree.abs;

import io.github.ai.behaviortree.ifs.ICondition;

/**
 * 条件同样是行为树的叶子节点，
 * 用于查看游戏世界信息（如敌人是否在攻击范围内，周围是否有可攀爬物体等），
 * 通过返回状态表示条件的成功。
 */
public abstract class BaseCondition extends BaseBehavior implements ICondition {
    protected boolean negation = false;

    @Override
    public boolean isNegation() {
        return negation;
    }

    @Override
    public void setNegation(boolean negation) {
        this.negation = negation;
    }

    protected int getRandom() {
        Double random = Math.random() * 100;
        //    int i = random.intValue();
        return random.intValue();
    }
}
