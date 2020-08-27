package io.github.ai.behaviortree.abs;


import io.github.ai.behaviortree.ifs.IBehaviour;
import io.github.ai.behaviortree.ifs.IDecorator;

/**
 * 装饰器（Decorator）是只有一个子节点的行为，
 * 顾名思义，装饰即是在子节点的原有逻辑上增添细节(如重复执行子节点，改变子节点返回状态等)
 */
public abstract class BaseDecorator extends BaseBehavior implements IDecorator {

    protected IBehaviour child;

    @Override
    public void addChild(IBehaviour child) {
        this.child = child;
    }
}