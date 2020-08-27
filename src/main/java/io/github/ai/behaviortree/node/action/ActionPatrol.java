package io.github.ai.behaviortree.node.action;


import io.github.ai.behaviortree.abs.BaseAction;
import io.github.ai.behaviortree.common.EStatus;
import io.github.ai.behaviortree.ifs.IBehaviour;

public class ActionPatrol extends BaseAction {

    @Override
    public EStatus update() {
        System.out.println("ActionPatrol 巡逻");


        return EStatus.Success;
    }

    @Override
    public void addChild(IBehaviour child) {
    }
}
