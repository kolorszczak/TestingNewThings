package eu.mihau.testingnewthings.common.base

import androidx.lifecycle.ViewModel
import eu.mihau.testingnewthings.utils.viewmodel.DisposablesOwner
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel(), DisposablesOwner {

    override val disposables = CompositeDisposable()

    override fun onCleared() {
        clearDisposables()
        super.onCleared()
    }
}