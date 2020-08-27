package io.github.ai.behaviortree.ifs;


import io.github.ai.behaviortree.common.EStatus;

public interface IBehaviour {

    EStatus tick();//Initialize--update--onTerminate

    void onInitialize();

    EStatus update();

    void onTerminate(EStatus Status);

    void release();

    void addChild(IBehaviour child);

    void setStatus(EStatus status);

    EStatus getStatus();

    void reset();

    void abort();
}