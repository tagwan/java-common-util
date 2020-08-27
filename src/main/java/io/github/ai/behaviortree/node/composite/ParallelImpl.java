package io.github.ai.behaviortree.node.composite;


import io.github.ai.behaviortree.abs.BaseComposite;
import io.github.ai.behaviortree.common.EPolicy;
import io.github.ai.behaviortree.common.EStatus;
import io.github.ai.behaviortree.ifs.IBehaviour;
import io.github.ai.behaviortree.ifs.composite.IParallel;

/**
 * 并行器（Parallel）是一种让多个行为并行执行的节点。
 * 但仔细观察便会发现实际上只是他们的更新函数在同一帧被多次调用而已。
 */
public class ParallelImpl extends BaseComposite implements IParallel {

    EPolicy successPolocy;
    EPolicy failPolocy;

    public  ParallelImpl(EPolicy successPolocy, EPolicy failPolocy) {
        this.successPolocy = successPolocy;
        this.failPolocy = failPolocy;
    }

    @Override
    public EStatus update() {
        int successCount = 0, failureCount = 0;
        int childrenSize = getChildren().size();
        for (IBehaviour iBehaviour : getChildren()) {
            //如果行为已经终止则不再执行该行为
            if (!(iBehaviour.getStatus().equals(EStatus.Success) || iBehaviour.getStatus().equals(EStatus.Failure)))
                iBehaviour.tick();

            if (iBehaviour.getStatus().equals(EStatus.Success)) {
                ++successCount;
                if (successPolocy.equals(EPolicy.RequireOne)) {
                    iBehaviour.reset();
                    return EStatus.Success;
                }
            }

            if (iBehaviour.getStatus().equals(EStatus.Failure)) {
                ++failureCount;
                if (failPolocy.equals(EPolicy.RequireOne)) {
                    iBehaviour.reset();
                    return EStatus.Failure;
                }
            }
        }

        if (failPolocy.equals(EPolicy.RequireAll) && failureCount == childrenSize) {
            for (IBehaviour iBehaviour : getChildren()) {
                iBehaviour.reset();
            }
            return EStatus.Failure;
        }
        if (successPolocy.equals(EPolicy.RequireAll) && successCount == childrenSize) {
            for (IBehaviour iBehaviour : getChildren()) {
                iBehaviour.reset();
            }
            return EStatus.Success;
        }

        return EStatus.Running;
    }

    @Override
    public void onTerminate(EStatus Status) {
        for (IBehaviour iBehaviour : getChildren()) {
            if(iBehaviour.getStatus().equals(EStatus.Running)){
                iBehaviour.abort();
            }

            iBehaviour.reset();
        }
    }
}
