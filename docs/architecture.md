Astra/
│
├── docs/
│   ├── architecture.md
│   ├── physics-notes.md
│   └── roadmap.md
│
├── assets/
│   └── textures/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── astra/
│   │           │
│   │           ├── core/
│   │           │   ├── Astra.java
│   │           │   ├── Engine.java
│   │           │   ├── EngineConfig.java
│   │           │   └── Time.java
│   │           │
│   │           ├── physics/
│   │           │   │
│   │           │   ├── body/
│   │           │   │   ├── Body.java
│   │           │   │   ├── MotionState.java
│   │           │   │   └── BodyType.java
│   │           │   │
│   │           │   ├── math/
│   │           │   │   ├── Vector2D.java
│   │           │   │   └── MathUtils.java
│   │           │   │
│   │           │   ├── force/
│   │           │   │   ├── Force.java
│   │           │   │   ├── Gravity.java
│   │           │   │   └── ForceGenerator.java
│   │           │   │
│   │           │   ├── collision/
│   │           │   │   ├── Collision.java
│   │           │   │   ├── CollisionDetector.java
│   │           │   │   └── CollisionResolver.java
│   │           │   │
│   │           │   ├── integration/
│   │           │   │   ├── Integrator.java
│   │           │   │   └── EulerIntegrator.java
│   │           │   │
│   │           │   ├── world/
│   │           │   │   └── PhysicsWorld.java
│   │           │   │
│   │           │   └── PhysicsSystem.java
│   │           │
│   │           ├── visualization/
│   │           │   ├── GamePanel.java
│   │           │   ├── Camera.java
│   │           │   └── Renderer.java
│   │           │
│   │           ├── demo/
│   │           │   ├── Main.java
│   │           │   └── Game.java
│   │           │
│   │           └── utils/
│   │
│   └── test/
│       └── java/
│           └── astra/
│               └── physics/
│
├── python/
│   ├── experiments/
│   └── tools/
│
├── README.md
└── .gitignore


________________________________________________________________


Astra/
│
├── docs/
│   ├── architecture.md
│   ├── physics-notes.md
│   └── roadmap.md
│
├── assets/
│   └── textures/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── astra/
│   │           │
│   │           ├── core/
│   │           │   └── Time.java
│   │           │
│   │           ├── physics/
│   │           │   │
│   │           │   ├── body/
│   │           │   │   ├── Body.java
│   │           │   │   └── MotionState.java
│   │           │   │
│   │           │   ├── math/
│   │           │   │   └── Vector2D.java
│   │           │   │
│   │           │   ├── force/
│   │           │   │   ├── Gravity.java
│   │           │   │   └── GravitationalForce.java
│   │           │   │
│   │           │   ├── collision/
│   │           │   │   ├── Collision.java
│   │           │   │   ├── CollisionDetector.java
│   │           │   │   └── CollisionResolver.java
│   │           │   │
│   │           │   ├── integration/
│   │           │   │   ├── Integrator.java
│   │           │   │   └── EulerIntegrator.java
│   │           │   │
│   │           │   ├── world/
│   │           │   │   └── PhysicsWorld.java
│   │           │   │
│   │           │   └── PhysicsSystem.java
│   │           │
│   │           ├── visualization/
│   │           │   └── GamePanel.java
│   │           │
│   │           ├── demo/
│   │           │   ├── Main.java
│   │           │   └── Game.java
│   │           │
│   │           └── utils/
│   │
│   └── test/
│       └── java/
│           └── astra/
│               └── physics/
│
├── python/
│   ├── experiments/
│   └── tools/
│
├── README.md
└── .gitignore