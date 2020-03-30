package com.example.spotifycloneapp.data

import com.example.spotifycloneapp.data.model.Radio
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import java.util.*

class RadioDataSource
{
 val radioServiceProvider=RadioServiceProvider()

    fun fetchPopularRadios(): Observable<Resource<List<Radio>>>
    {
        return Observable.create { emitter ->
            emitter.onNext(Resource.loading())
            radioServiceProvider
                .getRadioService()
                .getPopularRadios()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { emitter.onNext(Resource.success(it))
                      emitter.onComplete()
                    },
                    {
                        emitter.onNext(Resource.error(it.message?:"Error"))
                        emitter.onComplete()
                    })

        }
    }
    fun fetchLocationRadios(): Observable<Resource<List<Radio>>>
    {
        return Observable.create { emitter ->
            emitter.onNext(Resource.loading())
            radioServiceProvider
                .getRadioService()
                .getLocationRadios()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { emitter.onNext(Resource.success(it))
                        emitter.onComplete()
                    },
                    {
                        emitter.onNext(Resource.error(it.message?:"Error"))
                        emitter.onComplete()
                    })

        }
    }

}