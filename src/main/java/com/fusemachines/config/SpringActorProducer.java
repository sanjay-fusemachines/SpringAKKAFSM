package com.fusemachines.config;

import org.springframework.context.ApplicationContext;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;

public class SpringActorProducer implements IndirectActorProducer{

	    private final ApplicationContext applicationContext;
	    private final String actorBeanName;

	    public SpringActorProducer(ApplicationContext applicationContext,
	        String actorBeanName) {
	        this.applicationContext = applicationContext;
	        this.actorBeanName = actorBeanName;
	    }

	    public Actor produce() {
	        return (Actor) applicationContext.getBean(actorBeanName);
	    }

	    public Class<? extends Actor> actorClass() {
	        return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
	    }

}
