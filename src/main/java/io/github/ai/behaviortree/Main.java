package io.github.ai.behaviortree;


import io.github.ai.behaviortree.common.EPolicy;
import io.github.ai.behaviortree.node.action.ActionAttack;
import io.github.ai.behaviortree.node.action.ActionPatrol;
import io.github.ai.behaviortree.node.action.ActionRunaway;
import io.github.ai.behaviortree.node.composite.ParallelImpl;
import io.github.ai.behaviortree.node.composite.SelectorImpl;
import io.github.ai.behaviortree.node.composite.SequenceImpl;
import io.github.ai.behaviortree.node.condition.ConditionIsEnemyDead;
import io.github.ai.behaviortree.node.condition.ConditionIsHealthLow;
import io.github.ai.behaviortree.node.condition.ConditionIsSeeEnemy;
import io.github.ai.behaviortree.node.decorator.Repeat;

public class Main {
    public static void main(String[] args) {
        testBt();
    }

    /**
     * 这里我创建了一名角色，该角色一开始处于巡逻状态，
     * 一旦发现敌人，先检查自己生命值是否过低，如果是就逃跑，否则就攻击敌人，
     * 攻击过程中如果生命值过低也会中断攻击，立即逃跑，如果敌人死亡则立即停止攻击，
     * 这里我们使用了构建器来创建了一棵行为树，关
     * 于构建器的实现后面会讲到，
     * 这里每个函数创建了对应函数名字的节点，
     */
    public static void testBt() {
        BehaviorTreeBuilder builder = new BehaviorTreeBuilder();
        BehaviorTree behaviorTree =
            builder.addBehaviour(new SelectorImpl()) //一个成功就返回
                .addBehaviour(new SequenceImpl()) //一个失败返回
                        .addBehaviour(new ConditionIsSeeEnemy())
                        .back()
                        .addBehaviour(new SelectorImpl())
                            .addBehaviour(new SequenceImpl())
                                .addBehaviour(new ConditionIsHealthLow())
                                .back()
                                .addBehaviour(new ActionRunaway())
                                .back()
                            .back()
                            .addBehaviour(new ParallelImpl(EPolicy.RequireAll, EPolicy.RequireOne))
                                .addBehaviour(new ConditionIsEnemyDead(true))
                                .back()
                                .addBehaviour(new Repeat())
                                    .addBehaviour(new ActionAttack())
                                    .back()
                                .back()
                            .back()
                        .back()
                    .back()
                    .addBehaviour(new ActionPatrol())
                    .end();


        for (int i = 0; i < 10; ++i) {
            behaviorTree.tick();
            System.out.println("-------------" + i + "------------");
        }

        /**
         * 在上面的实现中，我在每个方法里创建对应节点，
         * 检测当前是否有根节点，如果没有则将其设为根节点，
         * 如果有则将其设为堆栈顶部节点的子节点，随后将其压入堆栈，
         * 每次调用back则退栈，每个创建节点的方法都返回this以方便调用下一个方法，
         * 最后通过End（）表示行为树创建完成并返回构建好的行为树。
         */
        System.out.println("pause ");
    }
}
