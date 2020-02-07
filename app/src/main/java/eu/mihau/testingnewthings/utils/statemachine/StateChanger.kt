package eu.mihau.testingnewthings.utils.statemachine

data class StateChanger<S>(
    val state: S,
    val sideEffect: SideEffect = SideEffect.empty
)