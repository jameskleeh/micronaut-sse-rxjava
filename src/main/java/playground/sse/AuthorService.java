package playground.sse;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import javax.inject.Singleton;

@Singleton
public class AuthorService {

    private Subject<Author> subject = PublishSubject.create();

    public void publish(Author author) {
        subject.onNext(author);
    }

    public Flowable<Author> getAuthors() {
        return subject.hide().toFlowable(BackpressureStrategy.BUFFER);
    }
}
