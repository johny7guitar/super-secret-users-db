package org.johny7guitar.supersecretusersdb.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Random;
import java.util.function.Function;

public class FakeExternalApi<T, ID>{

    private final Random random;
    private final CrudRepository<T, ID> repository;

    public FakeExternalApi(CrudRepository<T, ID> repository){
        this.repository = repository;
        this.random = new Random();
    }

    public <R>R simulateApiCall(Function<CrudRepository<T, ID>, R> repositoryAction){
        long fakeCallTime = 5000L + random.nextInt(5000);
        try{
            Thread.sleep(fakeCallTime);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return repositoryAction.apply(this.repository);
    }


}
