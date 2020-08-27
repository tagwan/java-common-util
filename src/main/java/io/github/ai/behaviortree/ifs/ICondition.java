package io.github.ai.behaviortree.ifs;

/**
 * 条件节点
 */
public interface ICondition extends IBehaviour {
    boolean isNegation();

    void setNegation(boolean negation);
}
