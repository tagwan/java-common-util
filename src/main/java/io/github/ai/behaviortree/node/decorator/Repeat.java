package io.github.ai.behaviortree.node.decorator;


import io.github.ai.behaviortree.abs.BaseDecorator;
import io.github.ai.behaviortree.common.EStatus;
import io.github.ai.behaviortree.ifs.IBehaviour;

public class Repeat extends BaseDecorator {

    private int limited = 3;
    private volatile int count = 0;

    @Override
    public EStatus update() {
        while (true) {
            child.tick();
            switch (child.getStatus()) {
                case Running:
                    return EStatus.Success;
                case Failure:
                    return EStatus.Failure;
                default:
                    break;
            }
            if (++count > limited)
                return EStatus.Success;
            child.reset();
        }
    }

    @Override
    public void onInitialize() {
        count = 0;
    }

    @Override
    public void addChild(IBehaviour child) {
        super.addChild(child);
    }
}
