package io.github.ai.behaviortree.node.composite;


import io.github.ai.behaviortree.abs.BaseComposite;
import io.github.ai.behaviortree.common.EStatus;
import io.github.ai.behaviortree.ifs.IBehaviour;
import io.github.ai.behaviortree.ifs.composite.ISequence;

import java.util.Iterator;

/**
 * 顺序器(Sequence)是复合节点的一种，
 * 它依次执行每个子行为，直到所有子行为执行成功或者有一个失败为止。
 */
public class SequenceImpl extends BaseComposite implements ISequence {

    private IBehaviour currChild;

    @Override
    public EStatus update() {
        Iterator<IBehaviour> iterator = getChildren().iterator();
        if (iterator.hasNext()) {
            while (true) {
                currChild = iterator.next();
                EStatus s = currChild.tick();
                //如果执行成功了就继续执行，否则返回
                if (s != EStatus.Success)
                    return s;
                if (!iterator.hasNext())
                    return EStatus.Success;
            }
        }
        return EStatus.Invalid;  //循环意外终止
    }
}
