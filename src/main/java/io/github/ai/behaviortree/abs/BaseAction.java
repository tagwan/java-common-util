package io.github.ai.behaviortree.abs;

import io.github.ai.behaviortree.ifs.IAction;

/**
 * 动作是行为树的叶子节点，表示角色做的具体操作（如攻击，上弹，防御等），
 * 负责改变游戏世界的状态。动作节点可直接继承自Behavior节点，
 * 通过实现不同的Update()方法实现不同的逻辑，
 * 在OnInitialize（）方法中获取数据和资源，在OnTerminate中释放资源。
 */
public abstract class BaseAction  extends BaseBehavior implements IAction {

}
