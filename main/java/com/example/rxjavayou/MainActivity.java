package com.example.rxjavayou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private Button btnData;
    private Button btnArray;
    private Button btnRange;
    private Button btnFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnData = findViewById(R.id.btnData);
        btnArray = findViewById(R.id.btnArray);
        btnRange = findViewById(R.id.btnRange);
        btnFilter = findViewById(R.id.btnFilter);
        GetName();
        StringArray();
        GetRange();
        GetStudentDetails();
    }

    private void StringArray() {
        String[] name = {"Prachi", "Aditya", "Leena", "Sudarshan", "Arya"};
        btnArray.setOnClickListener(view -> {
            Observable<String> stringObservable = Observable.fromArray(name);

            Observer<String> stringObserver = new Observer<String>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    Log.d("Prachi", "onSubscribe");
                }

                @Override
                public void onNext(@NonNull String s) {
                    Log.d("Prachi", "onNext" + name);

                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d("Prachi", "onError" + e.getMessage());
                }

                @Override
                public void onComplete() {
                    Log.d("Prachi", "onComplete");
                }
            };
            stringObservable.subscribe(stringObserver);
        });
    }

    private void GetName() {
        btnData.setOnClickListener(view -> {
            Observable<String> stringObservable = Observable.just("Prachi");

            Observer<String> stringObserver = new Observer<String>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    Log.d("Prachi", "onSubscribe");
                }

                @Override
                public void onNext(@NonNull String s) {
                    Log.d("Prachi", "onNext" + s);

                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d("Prachi", "onError" + e.getMessage());
                }

                @Override
                public void onComplete() {
                    Log.d("Prachi", "onComplete");
                }
            };
            stringObservable.subscribe(stringObserver);
        });
    }

    private void GetRange() {
        btnRange.setOnClickListener(view -> {
            Observable<Integer> stringObservable = Observable.range(20,20);

            Observer<Integer> stringObserver = new Observer<Integer>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    Log.d("Prachi", "onSubscribe");
                }

                @Override
                public void onNext(@NonNull Integer integer) {
                    Log.d("Prachi", "onNext" + integer.toString());
                }


                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d("Prachi", "onError" + e.getMessage());
                }

                @Override
                public void onComplete() {
                    Log.d("Prachi", "onComplete");
                }
            };
            stringObservable.subscribe(stringObserver);
        });
    }
    private void GetStudentDetails() {
        btnFilter.setOnClickListener(view -> {

                Observable<Student> studentDetailsObservable = Observable.fromIterable(getStudentDetails()).filter(new Predicate<Student>() {
                    @Override
                    public boolean test(Student studentDetails) throws Throwable {
                        return studentDetails.getStudentName().length() > 6;
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                Observer<Student> studentDetailsObserver = new Observer<Student>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d("Prachi", "onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull Student student) {
                        Log.d("Prachi", "Student List :- " + student.getStudentName() );
                    }



                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("Prachi", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("Prachi", "onComplete");
                    }
                };
                studentDetailsObservable.subscribe(studentDetailsObserver);
            });

    }
    private List<Student> getStudentDetails() {
        List<Student> studentDetailsList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Student studentDetails = new Student("1st", i, "Prachi");
            Student studentDetails1 = new Student("1st", i, "Aryaaaa");
            Student studentDetails2 = new Student("1st", i, "Leenaaaaa");
            Student studentDetails3 = new Student("1st", i, "Reeta");
            Student studentDetails4 = new Student("1st", i, "Pranjal");
            studentDetailsList.add(studentDetails);
            studentDetailsList.add(studentDetails1);
            studentDetailsList.add(studentDetails2);
            studentDetailsList.add(studentDetails3);
            studentDetailsList.add(studentDetails4);
        }
        return studentDetailsList;
    }
}
