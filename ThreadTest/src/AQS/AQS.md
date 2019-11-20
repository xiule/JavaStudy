AbstractQueuedSynchronize

ReentrantLock
            |
            |
            lock---->Sync.lock--->AQS
                  |
                  |
                  sync.acquire  