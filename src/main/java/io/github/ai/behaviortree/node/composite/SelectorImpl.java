package io.github.ai.behaviortree.node.composite;


import io.github.ai.behaviortree.abs.BaseComposite;
import io.github.ai.behaviortree.common.EStatus;
import io.github.ai.behaviortree.ifs.IBehaviour;
import io.github.ai.behaviortree.ifs.composite.ISequence;

import java.util.Iterator;

/**
 * 选择器（Selector）是另一种常用的复合行为，
 * 它会依次执行每个子行为直到其中一个成功执行或者全部失败为止
 */
public class SelectorImpl extends BaseComposite implements ISequence {

    private IBehaviour currChild;

    @Override
    public EStatus update() {
        Iterator<IBehaviour> iterator = getChildren().iterator();
        if (iterator.hasNext()) {
            while (true) {
                currChild = iterator.next();
                EStatus s = currChild.tick();
                //如果执行成功了就继续执行，否则返回
                if (s != EStatus.Failure)
                    return s;
                if (!iterator.hasNext())
                    return EStatus.Failure;
            }
        }
        return EStatus.Invalid;  //循环意外终止
    }

}
