package io.github.ai.behaviortree.abs;

import io.github.ai.behaviortree.common.EStatus;
import io.github.ai.behaviortree.ifs.IBehaviour;

public abstract class BaseBehavior implements IBehaviour {

    protected EStatus status;

    protected BaseBehavior() {
        setStatus(EStatus.Invalid);
    }

    public EStatus tick() {

        if (status != EStatus.Running) {
            onInitialize();
        }

        status = update();

        if (status != EStatus.Running) {
            onTerminate(status);
        }

        return status;
    }

    //  //释放对象所占资源
    public void release(){
    };
    public void setStatus(EStatus status) {
        this.status = status;
    }

    public EStatus getStatus() {
        return status;
    }

    @Override
    public void onInitialize() {
    }

    @Override
    public void onTerminate(EStatus Status) {
    }

    @Override
    public void reset() {
        setStatus(EStatus.Invalid);
    }

    @Override
    public void abort() {
        onTerminate(EStatus.Aborted);
        setStatus(EStatus.Aborted);
    }
}